package org.example;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking){
        Menuitem menuitem = menu.choose(menuName);
        Cook cook = cooking.makeCook(menuitem);

    }
}
