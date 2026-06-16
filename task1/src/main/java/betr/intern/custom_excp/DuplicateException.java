package betr.intern.custom_excp;

public class DuplicateException extends RuntimeException {
    public DuplicateException() {
        super("Duplicate number found, deleting root folder...");
    }
}
