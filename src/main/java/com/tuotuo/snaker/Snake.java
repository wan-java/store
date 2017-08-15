package com.tuotuo.snaker;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by 12130 on 2017/8/1.
 */
public class Snake {
    private Node head=null;
    private Node tail=null;
    private int size=0;

    private Node n=new Node(20,30,Dir.L);
    private Yard y;

    public Snake(Yard y){
        head=n;
        tail=n;
        size=1;
        this.y=y;
    }

    public void addToTail(){
        Node node=null;
        switch(tail.dir){
            case L:
                node=new Node(tail.row,tail.col+1,tail.dir);
                break;
            case U:
                node=new Node(tail.row+1,tail.col,tail.dir);
                break;
            case R:
                node=new Node(tail.row,tail.col-1,tail.dir);
                break;
            case D:
                nose=new Node(tail.row-1,tail.col,tail.dir);
                break;
        }
        tail.next=node;
        node.prev=tail;
        tail=node;
        size++;
    }
public void addToHead(){
        Node node=null;
        switch(head.dir) {
            case L:
                node = new Node(head.row, head.col - 1, head.dir);
                break;
            case U:
                node = new Node(head.row - 1, head.col, head.dir);
                break;
            case R:
                node = new Node(head.row, head.col + 1, head.dir);
                break;
            case D:
                node = new Node(head.row + 1, head.col, head.dir);
                break;
            }
        node.next=head;
        head.prev=node;
        head=node;
        size++;
        }
public void draw(Graphics g){
    Color c=g.getColor();
    g.setColor(Color.BLACK);
    g.fillRect(Yard.BLOCK_SIZE*col,Yard.BLOCK_SIZE*row,w,h,);
    g.setColor(c);
    }
public void eat(Egg e) {
        if (this.getRect().intersects(e.getREct())) {
            e.reAppear();
            this.addToHead();
            y.setScore(y.getScore() + 5);
        }
    }
public Rectangle getRect(){
    return new Rectangle(Yard.BLOCK_SIZE*head.col,Yara.BLOCK_SIZE*head.row,head.w,head.h);
    }

public void keyPressed1(KeyEvent e){
    int key=e.getKeyCode();
    switch (key){
        case KeyEvent.VK_LEFT:
            if(head.dir!=Dir.R)
                head.dir=Dir.l;
            break;
        case KeyEvent.VK_UP:
            if(head.dir!=Dir.D)
                head.dir=Dir.U;
            break;
        case KeyEvent.VK_RIGHT:
            if(head.dir!=Dir.L)
                head.dir=Dir.R;
        case KeyEvent.VK_DOWN:
            if(hea.dir!=Dir.U)
                head.dir=Dir.D;
            break;
    }
}

}

