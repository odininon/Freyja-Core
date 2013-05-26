package com.freyja.core;

import cpw.mods.fml.relauncher.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

/**
 * @author Freyja
 *         Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FreyjaCoreTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if (bytes == null) return bytes;

        bytes = injectIntoItem(name, transformedName, bytes);
        return bytes;
    }

    private byte[] injectIntoItem(String name, String transformedName, byte[] bytes)
    {
        if (transformedName.equals("net.minecraft.item.Item")) {
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytes);

            classReader.accept(classNode, 0);

            MethodNode vanillaMethod = null;
            for (Object method : classNode.methods) {
                MethodNode node = (MethodNode) method;
                if (node.name.equals("<init>")) {
                    vanillaMethod = node;
                    break;
                }
            }

            MethodNode moddedMethod = vanillaMethod;
            AbstractInsnNode last = moddedMethod.instructions.getLast().getPrevious().getPrevious().getPrevious();
            moddedMethod.instructions.insertBefore(last, new VarInsnNode(Opcodes.ALOAD, 0));
            moddedMethod.instructions.insertBefore(last, new MethodInsnNode(Opcodes.INVOKESTATIC, "com/freyja/core/utils/FreyjaGameData", "newItemAdded", "(Lnet/minecraft/item/Item;)V"));

            classNode.methods.remove(vanillaMethod);
            moddedMethod.accept(classNode);

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            classNode.accept(writer);
            return writer.toByteArray();
        }

        return bytes;
    }
}
