import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {
    Map<String, Integer> pathValueMap = new HashMap<>();

    public boolean createPath(String path, int value) {
        if (!isPathValid(path)) {
            return false;
        } else {
            List<String> pathList = this.parsePath(path);
            if (pathList.size() == 1) {
                pathValueMap.put(path, value);
                return true;
            } else {
                String parent = pathList.get(0);
                if (pathValueMap.containsKey(parent)) {
                    pathValueMap.put(path, value);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int get(String path) {
        if (pathValueMap.containsKey(path)) {
            return pathValueMap.get(path);
        }
        return -1;
    }

    private boolean isPathValid(String path) {
        if (path.isBlank() || path.length() == 1 || path.charAt(0) != '/') {
            return false;
        }

        return true;
    }

    private List<String> parsePath(String path) {
        List<String> result = new ArrayList<>();
        int lastIndex = path.lastIndexOf("/");
        if (lastIndex == 0) {
            result.add(path);
        } else {
            String parent = path.substring(0, lastIndex);
            String child = path.substring(lastIndex + 1);
            result.add(parent);
            result.add(child);
        }
        return result;
    }
}
