/**
 * Generates the bytecode necessary to implement a while loop
*/
import static utils.Utilities.writeFile;
import org.objectweb.asm.*;

public class gen7 {

    public static void main(String[] args)
    {

        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        
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
         * Implements a while loop
         */
        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            // Creates a label (a place to jump to) to end the program
            Label endLabel = new Label();
            // Creates a label (a place to jump to) to the beginning the program
            Label loop = new Label();

            /**
             * Stores an int constant to the stack 
             */
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            /**
             * Visits the label where the loop starts
             */
            mv.visitLabel(loop);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitIntInsn(Opcodes.BIPUSH, 20);
            // jumps to the endLabel if the element in the stack varIndex 1 is greater than or equal to the element in the stack 
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, endLabel);
            /**
             * Calls the PrintStream class to print an int and a string
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"I think I know what I am doing");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitIincInsn(1,1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            
            /**
             * Goes to another instruction(label)
             */
            mv.visitJumpInsn(Opcodes.GOTO, loop);
            
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
        writeFile(b,"program7.class");
        System.out.println("Done!");
    }//end main
}
