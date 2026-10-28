public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {
        // Директории не добавляют размер напрямую
    }

    public int getTotalSize() {
        return totalSize;
    }
}