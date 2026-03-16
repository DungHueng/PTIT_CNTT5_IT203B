package Demo.ISP;

import java.util.List;

public interface BaseService {
    List<String> finalAll();
    String addNew();
    String update();
    void delete();
    List<String> pagination();
}
