/**
 * Generates the bytecode necessary to divide two numbers (I, L, F, and D)
 * store them, and then print each result
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen3 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program3", null, "java/lang/Object",null);
        
			
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
         * Divide two numbers (I, L, F, and D), store them, and then print each result
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        
            mv.visitCode();

            /**
             * Pushes ints to the stack and stores them
             */
            mv.visitIntInsn(Opcodes.BIPUSH, 20);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitIntInsn(Opcodes.BIPUSH, 10);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            /**
             * Loads ints to the stack and divides them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            mv.visitInsn(Opcodes.IDIV);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            /**
             * Calls the PrintStream class to print an int
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

         
            /**
             * Pushes longs to the stack and stores them
             */
            mv.visitLdcInsn((Long)20l);
            mv.visitVarInsn(Opcodes.LSTORE,1);
            mv.visitLdcInsn((Long)10l);
            mv.visitVarInsn(Opcodes.LSTORE,3);
            /**
             * Loads longs to the stack and divides them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.LLOAD,1);
            mv.visitVarInsn(Opcodes.LLOAD,3);
            mv.visitInsn(Opcodes.LDIV);
            mv.visitVarInsn(Opcodes.LSTORE,5);
            /**
             * Calls the PrintStream class to print a long
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
         

            /**
             * Pushes floats to the stack and stores them
             */
            mv.visitLdcInsn((Float)20.00f);
            mv.visitVarInsn(Opcodes.FSTORE,1);
            mv.visitLdcInsn((Float)10.00f);
            mv.visitVarInsn(Opcodes.FSTORE,2);
            /**
             * Loads floats to the stack and divides them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.FLOAD,1);
            mv.visitVarInsn(Opcodes.FLOAD,2);
            mv.visitInsn(Opcodes.FDIV);
            mv.visitVarInsn(Opcodes.FSTORE,3);
            /**
             * Calls the PrintStream class to print a float
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
            

            /**
             * Pushes double to the stack and stores them
             */
            mv.visitLdcInsn((Double)20.00);
            mv.visitVarInsn(Opcodes.DSTORE,1);
            mv.visitLdcInsn((Double)10.00);
            mv.visitVarInsn(Opcodes.DSTORE,3);
            /**
             * Loads doubles to the stack and divides them
             * And store them 
             */
            mv.visitVarInsn(Opcodes.DLOAD,1);
            mv.visitVarInsn(Opcodes.DLOAD,3);
            mv.visitInsn(Opcodes.DDIV);
            mv.visitVarInsn(Opcodes.DSTORE,5);
            /**
             * Calls the PrintStream class to print a double
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            
            //exit
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();
        /**
         * Creates the class with the bytecode
         */
        byte[] b = cw.toByteArray();
        writeFile(b,"program3.class");
        System.out.println("Done!");
    }//end main
}
