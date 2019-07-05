//package com.queue;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class MyStake {
//    /**
//     * Created with IntelliJ IDEA.
//     * Description: 两个队列实现栈
//     * User: GAO BO
//     * Date: 2019-05-23
//     * Time: 21:02
//     */
//    Queue<Integer> queue = new LinkedList<>();
//    Queue<Integer> queue2 = new LinkedList<>();
//
//    public class TestMyStack {
//        private MyQueue myQueue1;
//        private MyQueue myQueue2;
//
//        public TestMyStack(){
//            myQueue1 = new MyQueue();
//            myQueue2 = new MyQueue();
//        }
//
//        /** Push element x onto stack. */
//        public void push(int x) {
//            if(!myQueue1.empty()) {
//                myQueue1.add(x);
//            } else {
//                myQueue2.add(x);
//            }
//
//        }
//
//        /** Removes the element on top of the stack and returns that element. */
//        public int pop() {
//            int oldData;
//            if(!myQueue1.empty()) {
//                for(int i=0; i<myQueue1.size()-1;i++) {
//                    myQueue2.add(myQueue1.poll(););
//                }
//                oldData = myQueue1.poll();
//            } else {
//                for(int i=0; i<myQueue2.size()-1;i++) {
//                    myQueue1.add(myQueue2.poll();
//                }
//                oldData = myQueue2.poll();
//            }
//
//        }
//
//        /** Get the top element. */
//        public int top() {
//            int oldData;
//            if(!myQueue1.empty()) {
//                for(int i=0; i<myQueue1.size();i++) {
//                    oldData = myQueue1.poll();
//                    myQueue2.add(myQueue1.poll());
//
//                }
//            } else {
//                for(int i=0; i<myQueue2.size();i++) {
//                    oldData = myQueue2.poll();
//                    myQueue1.add(myQueue2.poll());
//                }
//
//            }
//
//
//        }
//
//        /** Returns whether the stack is empty. */
////        public boolean empty() {
////
////
////        }
//
//
//    }
//
//}
