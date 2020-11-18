package aula6.ex2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class ListsProcess {
		public static <T> List<T> filter(List<T> list, Predicate<T> cond)
		{
			List<T> filtrada = new ArrayList<>();
			for(T element : list)
			{
				if(cond.test(element))
				{
					filtrada.add(element);
				}
			}
			
			return filtrada;
		}
	
}
