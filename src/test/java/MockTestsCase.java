
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockTestsCase {


    @Mock
    List mockList;

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {


        mockList.add("one");
        verify(mockList).add("one");

        assertEquals(0, mockList.size());

        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {

        spiedList.add("one");
        spiedList.add("two");
        verify(spiedList).add("one");
        verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());

    }




    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());
    }


}
