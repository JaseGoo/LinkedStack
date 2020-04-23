package ind.Jase.Stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        StackNode s1 = new StackNode("1");
        StackNode s2 = new StackNode("2");
        StackNode s3 = new StackNode("3");

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(s1);
        linkedStack.push(s2);
        linkedStack.push(s3);
        linkedStack.pop();
        String s = linkedStack.toString();
        System.out.println(s);
    }
}

class LinkedStack{
    private StackNode top = new StackNode("0",null);//定义头结点
    private int size = 0;

    public void push(StackNode s){//入栈
        //链式存储,一般不考虑栈满的情况
        s.next = top;
        top = s;
        size++;
    }

    public Object pop(){//出栈
        if(size == 0){
            throw new RuntimeException("Stack is empty");//此时栈为空
        }
        StackNode temp = top;//用临时结点存放当前要出栈的结点;
        top = top.next;//栈顶后移
        temp.next = null;//将临时结点的下一位指向空
        size--;

        return temp.data;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        else {
            StringBuilder sb = new StringBuilder("[");

            for (StackNode current = top; current != null; current = current.next) {
                sb.append(current.data.toString() + ", ");
            }

            sb.append("]");

            int length = sb.length();

            return sb.delete(length - 3, length - 1).toString();
        }
    }


}

class StackNode{
    public Object data;
    public StackNode next;

    public StackNode(Object data){
        this.data = data;
    }

    public StackNode(Object data, StackNode next) {
        this.data = data;
        this.next = next;
    }
}
