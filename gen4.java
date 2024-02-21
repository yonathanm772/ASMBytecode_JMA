/**
 * Generates the bytecode necessary to compare two numbers (I, S, L) 
 * to determine which is bigger and print it
*/
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen4 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
        /**
         * Created the default constructor
         */
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}

        /**
         * Compares two numbers (I, S, L) 
         * to determine which is bigger and print it
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            // Creates a label (a place to jump to) to end the program

            Label endLabel = new Label();

            /**
             * Pushes ints to the stack and stores them
             */
            mv.visitIntInsn(Opcodes.BIPUSH, 20);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitIntInsn(Opcodes.BIPUSH, 10);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            /**
             * Loads ints to the stack 
             *  
             */
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            // jumps to the endLabel if the element in the stack varIndex 1 is less than or equal to the element in the stack varIndex 2
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, endLabel);
            /**
             * Calls the PrintStream class to print an int and a string
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The number above is bigger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            

            /**
             * Pushes shorts to the stack and stores them
             */
            mv.visitIntInsn(Opcodes.SIPUSH, 1112);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitIntInsn(Opcodes.SIPUSH, 1111);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            /**
             * Loads shorts as int equivalents to the stack and compares them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            // jumps to the endLabel if the element in the stack varIndex 1 is less than or equal to the element in the stack varIndex 2
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, endLabel);
            /**
             * Calls the PrintStream class to print an int
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The number above is bigger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            
            /**
             * Pushes longs to the stack and stores them
             */
            mv.visitLdcInsn((Long)2000000l);
            mv.visitVarInsn(Opcodes.LSTORE,1);
            mv.visitLdcInsn((Long)1000000l);
            mv.visitVarInsn(Opcodes.LSTORE,3);
            /**
             * Loads longs to the stack and compares them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.LLOAD,1);
            mv.visitVarInsn(Opcodes.LLOAD,3);
            mv.visitInsn(Opcodes.LCMP);
            // jumps to the endLabel if the element in the stack varIndex 1 is less than or equal to the element in the stack varIndex 3
            mv.visitJumpInsn(Opcodes.IFLE, endLabel);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The number above is bigger");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            // exit code
            mv.visitLabel(endLabel);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        
        

        cw.visitEnd();
        /**
         * Creates the class with the bytecode
         */
        byte[] b = cw.toByteArray();
        writeFile(b,"program4.class");
        System.out.println("Done!");
    }//end main
}
