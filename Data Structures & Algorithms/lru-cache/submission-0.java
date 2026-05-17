class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // used again;
        if(!map.containsKey(key)){
            return -1;
        }
        Node tempNode = map.get(key);
        remove(tempNode);
        insert(tempNode);
        return tempNode.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node tempNode = map.get(key);
            remove(tempNode);
            map.remove(key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if(map.size()>this.capacity){
            Node removeNode = tail.prev;
            map.remove(removeNode.key);
            remove(removeNode);
        }
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        node.prev = null;
        node.next = null;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insert(Node node){
        Node tempNext = this.head.next;
        tempNext.prev = node;
        node.next = tempNext;
        node.prev = this.head;
        this.head.next = node;
    }
}

// deque
// last .....................first
// in/out ......................in/out


// Queue
// last......................first
// in........................out

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */