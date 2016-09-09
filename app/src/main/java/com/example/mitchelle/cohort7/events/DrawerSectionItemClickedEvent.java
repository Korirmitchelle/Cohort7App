package com.example.mitchelle.cohort7.events;

/**
 * Created by mitchelle on 9/1/16.
 */
public class DrawerSectionItemClickedEvent {
    public String section;

    public DrawerSectionItemClickedEvent(String section){
        this.section = section;
    }
/*
used by eventbus to share informaion from navigation drawer to the rest of app
*/
}
