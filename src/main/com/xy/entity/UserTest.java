package com.xy.entity;

/**
 * @Description
 * @Author TeaBen
 * @Date 2020-09-16 10:39
 */
public class UserTest {
  int a=10;
  public void test(){
    if(Math.random()>0.5){
      a=15;
    }else{
      a=15/0;
    }
    System.out.println(a);
  }
}
