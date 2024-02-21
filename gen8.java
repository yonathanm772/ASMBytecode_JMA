/**
 * Generates the bytecode necessary to Implement If. . . Then . . . Else statement
*/
import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen8 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program8", null, "java/lang/Object",null);
        
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
         * Implements If. . . Then . . . Else statement
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            // Creates a label (a place to jump to) to end the program
            Label endLabel = new Label();
            // Creates a label (a place to jump to) to end the program
            Label greaterNum = new Label();

            /**
             * Pushes ints to the stack and stores them
             */
            mv.visitIntInsn(Opcodes.BIPUSH, 10);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitIntInsn(Opcodes.BIPUSH, 20);
            mv.visitVarInsn(Opcodes.ISTORE,2);
            /**
             * Loads ints to the stack and compares them
             */
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,2);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, greaterNum);
            /**
             * Calls the PrintStream class to print a string
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The number is smaller");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); 
            /**
             * Goes to another instruction(label)
             */
            mv.visitJumpInsn(Opcodes.GOTO, endLabel);
            /**
             * Calls the PrintStream class to print a string0
             */
            mv.visitLabel(greaterNum);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"The number is bigger");
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
        writeFile(b,"program8.class");
        System.out.println("Done!");
    }//end main
}
