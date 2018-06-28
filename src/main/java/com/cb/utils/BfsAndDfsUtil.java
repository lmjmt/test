package com.cb.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历BFS（Breadth First Search）
 * DFS（Depth First Search）深度优先搜索
 * BFS多用于寻找最短路径的问题，DFS多用于快速发现底部节点
 * Created by luminjie on 2018/6/28.
 */
public class BfsAndDfsUtil {
    //全局变量count记录了进入每个节点和离开每个节点的时间
    private static int count;

    /**
     *BFS向外扩散的方式得到的距离就是最短距离
     * 从起始点开始，将其邻近的所有顶点都加到一个队列（FIFO）中去，然后标记下这些顶点离起始顶点的距离为1.
     * 最后将起始顶点标记为已访问，今后就不会再访问。然后再从队列中取出最先进队的顶点A，也取出其周边邻近节点，
     * 加入队列末尾，将这些顶点的距离相对A再加1，最后离开这个顶点A。依次下去，直到队列为空为止
     * @param graph
     * @param dist 这个hash表来记录每个顶点离s的距离
     * @param start
     */
    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start)
    {
        Queue<Character> q=new LinkedList<>();
        q.add(start);//将s作为起始顶点加入队列
        dist.put(start, 0);
        int i=0;
        while(!q.isEmpty())
        {
            char top=q.poll();//取出队首元素
            i++;
            System.out.println("The "+i+"th element:"+top+" Distance from s is:"+dist.get(top));
            int d=dist.get(top)+1;//得出其周边还未被访问的节点的距离
            for (Character c : graph.get(top)) {
                if(!dist.containsKey(c))//如果dist中还没有该元素说明还没有被访问
                {
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
    }

    /**
     * 从起始顶点开始，递归访问其所有邻近节点，比如A节点是其第一个邻近节点，而B节点又是A的一个邻近节点，
     * 则DFS访问A节点后再访问B节点，如果B节点有未访问的邻近节点的话将继续访问其邻近节点，
     * 否则继续访问A的未访问邻近节点，当所有从A节点出去的路径都访问完之后，继续递归访问除A以外未被访问的邻近节点
     * @param graph
     * @param visited
     */
    private static void dfs(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited)
    {
        visit(graph, visited, 'u');//为了和图中的顺序一样，我认为控制了DFS先访问u节点
        visit(graph,visited,'w');
    }
    private static void visit(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited,char start)
    {
        if(!visited.containsKey(start))
        {
            count++;
            System.out.println("The time into element "+start+":"+count);//记录进入该节点的时间
            visited.put(start, true);
            for (char c : graph.get(start))
            {
                if(!visited.containsKey(c))
                {
                    visit(graph,visited,c);//递归访问其邻近节点
                }
            }
            count++;
            System.out.println("The time out element "+start+":"+count);//记录离开该节点的时间
        }
    }

    public static void main(String args[]) {
        BfsAndDfsUtil bb = new BfsAndDfsUtil();
        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('u');
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        char start = 's';
        bb.bfs(graph, dist, start);
    }
}
