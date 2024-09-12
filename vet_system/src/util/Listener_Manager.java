package util;

import java.util.ArrayList;
import java.util.List;

import model.to_do;
import model.ownerandpet.pet;

public class Listener_Manager {
	private static Listener_Manager instance;
    private List<AddListener> listeners = new ArrayList<>();
    private Listener_Manager() {}
    
    public static synchronized Listener_Manager getInstance() {
        if (instance == null) {
            instance = new Listener_Manager();
        }
        return instance;
    }

	//新增監聽
	public void addListener(AddListener listener)
	{
		listeners.add(listener);
	}
	
	//移除監聽
	public void removeListener(AddListener listener)
	{
		listeners.remove(listener);
	}
	//通知所有監聽器
	public <T> void notifyListeners(T item) {
		for(AddListener listener : listeners) {
			try {
			//System.out.println("通知監聽器: " + listener.getClass().getSimpleName());
			listener.onItemAdded(item);
		}catch(Exception e) {
			System.err.println("Listener Error :" + listener.getClass().getSimpleName());
			e.printStackTrace();
		}
	}
		
	}

	
	
}//最後一個
