/**
 * Generates the bytecode necessary to 
 * Get input from the user using the Scanner class (I, L, and D)
*/
import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen6 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program6", null, "java/lang/Object",null);
        
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
         * Gets input (I, L, and D) from the user using the Scanner class 
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();

            /**
             * Imports the Scanner class and duplicates the value on top of the stack
             */
            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            mv.visitInsn(Opcodes.DUP);
            /**
             * Initializes the scanner class and stores it
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "in", "Ljava/io/InputStream;");
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            /**
             * Calls the PrintStream class to print a string
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Please enter an integer");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            /**
             * Loads the scanner class to scan the next integer input and store it
             */
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            /**
             * Calls the PrintStream class to print a string and an integer
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Your input is:");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            /**
             * Closes the scanner object
             */
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "close", "()V", false);
            
            //exit code
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        
        cw.visitEnd();
        /**
         * Creates the class with the bytecode
         */
        byte[] b = cw.toByteArray();
        writeFile(b,"program6.class");
        System.out.println("Done!");
    }//end main
}
