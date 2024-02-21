/**
 * Generates the bytecode necessary to declare and print String Variables
*/
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen5 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program5", null, "java/lang/Object",null);
        
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
         * Declares and prints String Variables
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            /**
             * Declares string variables as objects and stores them
             */
            mv.visitLdcInsn((String)"Hello world");
            mv.visitVarInsn(Opcodes.ASTORE,1);
            /**
             * Calls the PrintStream class to print a String
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD,1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            /**
             * Declares string variables as objects and stores them
             */
            mv.visitLdcInsn((String)"I like game development");
            mv.visitVarInsn(Opcodes.ASTORE,1);
            /**
             * Calls the PrintStream class to print a String
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD,1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            /**
             * Declares string variables as objects and stores them
             */
            mv.visitLdcInsn((String)"I like pizza");
            mv.visitVarInsn(Opcodes.ASTORE,1);
            /**
             * Calls the PrintStream class to print a String
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD,1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            // exit code
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        
        

        cw.visitEnd();
        /**
         * Creates the class with the bytecode
         */
        byte[] b = cw.toByteArray();
        writeFile(b,"program5.class");
        System.out.println("Done!");
    }//end main
}
