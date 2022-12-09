package org.example;

import java.util.List;

public class Menu {
    private final List<Menuitem> menuitems;
    public Menu(List<Menuitem> menuitems){
        this.menuitems = menuitems;
    }

    public Menuitem choose(String name) {
        return this.menuitems.stream()
                .filter(menuitem -> menuitem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("잘못된 메뉴 이름입니다."));
    }
}
