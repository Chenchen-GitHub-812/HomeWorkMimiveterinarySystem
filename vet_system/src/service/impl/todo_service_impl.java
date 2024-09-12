package service.impl;

import java.util.List;


import daO.todo.impl.todo_dao_impl;
import model.to_do;
import service.to_do_service;

public class todo_service_impl implements to_do_service{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static todo_dao_impl toddi = new todo_dao_impl();
	@Override
	public void addToDo(to_do td) {
		// TODO Auto-generated method stub
		toddi.insert(td);
	}

	@Override
	public Object[][] searchfished(String finished) {
		// TODO Auto-generated method stub
		Object[][] objectTodo=toddi.searchFinished(finished);
		return objectTodo;
	}

	@Override
	public void update(int number,  String finishstaffnumber) {
		// TODO Auto-generated method stub
		toddi.update(number,  finishstaffnumber);
	}

	@Override
	public void delete(int number) {
		// TODO Auto-generated method stub
		toddi.delete(number);
	}

	@Override
	public List<to_do> searchnumber(int number) {
		// TODO Auto-generated method stub
		return toddi.searchnumber(number);
	}

	
}
