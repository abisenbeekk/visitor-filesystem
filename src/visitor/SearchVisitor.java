package visitor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String extension;
    private final List<String> foundPaths = new ArrayList<>();
    private final Deque<String> currentPath = new ArrayDeque<>();

    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(extension)) {
            foundPaths.add(String.join("/", currentPath) + "/" + file.getName());
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        currentPath.addLast(directory.getName());
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
        currentPath.removeLast();
    }

    public List<String> getFoundPaths() {
        return foundPaths;
    }
}