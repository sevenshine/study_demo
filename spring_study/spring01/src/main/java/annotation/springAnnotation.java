package annotation;

import java.util.ArrayList;
import java.util.List;

public class springAnnotation extends Object{

    //镇压警告
    @SuppressWarnings("all")
    public void test01(){
        List list=new ArrayList();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
