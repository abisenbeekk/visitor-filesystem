package visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory docs = new Directory("docs");
        docs.add(new File("report.pdf", 2048));
        docs.add(new File("notes.txt", 512));

        Directory test = new Directory("test");
        test.add(new File("MainTest.java", 600));

        Directory src = new Directory("src");
        src.add(new File("Main.java", 1500));
        src.add(new File("Utils.java", 800));
        src.add(test);

        root.add(docs);
        root.add(src);
        root.add(new File("readme.md", 300));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("=== Total size ===");
        System.out.println(sizeVisitor.getTotalSize() + " bytes");

        SearchVisitor searchVisitor = new SearchVisitor(".java");
        root.accept(searchVisitor);
        System.out.println("\n=== Search: *.java ===");
        searchVisitor.getFoundPaths().forEach(System.out::println);
    }
}