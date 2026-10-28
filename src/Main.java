public class Main {
    public static void main(String[] args) {
        // Построение структуры файловой системы
        Directory root = new Directory("root");
        File document1 = new File("resume.pdf", 1200);
        File document2 = new File("cover_letter.docx", 500);

        Directory mediaDir = new Directory("media");
        File photo1 = new File("vacation.jpg", 3500);
        File photo2 = new File("profile.png", 2100);

        mediaDir.addElement(photo1);
        mediaDir.addElement(photo2);

        root.addElement(document1);
        root.addElement(document2);
        root.addElement(mediaDir);

        // 1. Посетитель подсчета размера
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("--- Visitor 1: Total Size Calculation ---");
        System.out.println("Total File System Size: " + sizeVisitor.getTotalSize() + " KB");

        // 2. Посетитель поиска по расширению (.jpg)
        SearchVisitor searchVisitor = new SearchVisitor(".jpg");
        root.accept(searchVisitor);
        System.out.println("\n--- Visitor 2: Search Files by Extension (.jpg) ---");
        for (File matchedFile : searchVisitor.getMatchedFiles()) {
            System.out.println("Found match: " + matchedFile.getName() + " (" + matchedFile.getSize() + " KB)");
        }
    }
}