package Demo.ISP;

import java.util.List;

public class CategoryService implements ProductBase{
    @Override
    public List<String> finalAll() {
        return List.of();
    }

    @Override
    public String addNew() {
        return "";
    }

    @Override
    public String update() {
        return "";
    }

    @Override
    public void delete() {

    }

    @Override
    public List<String> pagination() {
        return List.of();
    }
}
