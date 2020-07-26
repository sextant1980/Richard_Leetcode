package JunitPrac;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import org.hamcrest.Matchers;
import LittleSkills.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryJunitHere {



    @Test
    public void testPrac1() {
        Abc abc = new Abc();
        List<Integer> myList = abc.getMyList();
//        assertThat(myList, contains(3));
    }
}
