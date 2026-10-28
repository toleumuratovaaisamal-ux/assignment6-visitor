import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String targetExtension;
    private final List<File> matchedFiles = new ArrayList<>();

    public SearchVisitor(String targetExtension) {
        this.targetExtension = targetExtension;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(targetExtension)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        // Директории пропускаются при фильтрации файлов
    }

    public List<File> getMatchedFiles() {
        return Collections.unmodifiableList(matchedFiles);
    }
}