/**
 * Generates the bytecode necessary to get an input (I or D), from the user
 * run a loop that adds that number to an accumulator, and then print the result.
*/
import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen9 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program9", null, "java/lang/Object",null);
        
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
        * Get san input (I or D), from the user
        * run a loop that adds that number to an accumulator, 
        * and then print the result.
        */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            /**
             * Creates 3 labels, 
             * a label to the beggining of the loop,  
             * a label to the end of the program
             * a label to the accumulator
             */
            Label loop = new Label();
            Label endLabel = new Label();
            Label accumulator = new Label();

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
             * Pushes two constants to the stack and stores them
             */
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            /*
             * Beginning of the loop
             */
            mv.visitLabel(loop);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            // loads the value of -1 to the stack
            mv.visitInsn(Opcodes.ICONST_M1);
            // jumps to the endLabel if the element in the stack varIndex 2 is equal to the element in the stack
            mv.visitJumpInsn(Opcodes.IF_ICMPEQ, endLabel);
            /**
             * Calls the PrintStream class to print strings
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Please enter an integer");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Enter \'-1\' to quit");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            /**
             * Loads the scanner class to scan the next integer input and store it
             */
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            // loads the value of -1 to the stack
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitInsn(Opcodes.ICONST_M1);
            // jumps to the endLabel if the element in the stack varIndex 2 is not equal to the element in the stack
            mv.visitJumpInsn(Opcodes.IF_ICMPNE, accumulator);
            /**
             * Calls the PrintStream class to print strings and an int
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The session is over");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Your final total is:");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            /**
             * Goes to another instruction(label)
             */
            mv.visitJumpInsn(Opcodes.GOTO, loop);
            /**
             * Loads 2 ints into the stack and adds them up
             * Additionally, it prints the result and goes to the beginning of the loop
             */
            mv.visitLabel(accumulator);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitInsn(Opcodes.IADD);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Your total is:");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, loop);

            // exit code
            mv.visitLabel(endLabel);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "close", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        
        

        cw.visitEnd();
        /**
         * Creates the class with the bytecode
         */
        byte[] b = cw.toByteArray();
        writeFile(b,"program9.class");
        System.out.println("Done!");
    }//end main
}
