package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSizeInBytes();
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public long getTotalSize() {
        return totalSize;
    }
}
