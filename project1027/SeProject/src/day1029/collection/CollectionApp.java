package day1029.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;

//ArrayList : 순서있는 Collection<E> , 중복 o
//Set : 순서있는 Collection<E> , 중복 x
//Map : 순서있는 Collection<E,E> , 중복 x
public class CollectionApp {
	public void showList() {
		List list = new ArrayList();
		list.add("사과");
		list.add("복숭아");
		list.add("멜론");
		list.add(1);
		list.add("멜론");
		list.add("멜론");
		list.add(new JButton("나버튼"));
		System.out.println(list);
		JButton jb = (JButton)list.get(6);
		System.out.println(jb.getText());
		
	}
	public void showSet() {
		Set ss = new HashSet(); 	// ss는 Set을 가르키고있지만
									// HashSet에서 오버라이딩 된 메소드에도 접근가능
		HashSet set = new HashSet(); // HashSet과 Set 모든 메소드에 접근 가능
		set.add("사과");
		set.add("사과");
		set.add("바나나");
		set.add("바나나");
		set.add("블루베리");
		set.add("블루베리");
		System.out.println(set);
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	public void showMap() {
		HashMap<Integer, String> hm = new HashMap();
		hm.put(1,"h2");
		hm.put(2,"h3");
		hm.put(3,"h4");
		System.out.println(hm);
		// Iterator<E> : E는 HashMap의<E,?> E와 같아야함
		// HashMap.keySet<E>는 반환형이 Set<E>임
		// 즉 HashMap을 keySet으로  key만을 Set으로 구성 후, Set의 Iterator로 생성
		Iterator<Integer> hmit = hm.keySet().iterator();
		while (hmit.hasNext()) {
			Integer key = hmit.next();
			String Value = hm.get(key);
			System.out.println(key + " : " + Value);
		}
	}
	
	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.showList();
		app.showSet();
		app.showMap();
		
	}
}
