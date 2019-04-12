package LinkedList;
    public class DoubleLinkedList<E>  {
        protected NodeD<E> top;      // The first NodeD<E> in the list

        // This instance variable is not required, however if you
        // find it useful, then you are welcome to use it
        protected NodeD<E> cursor;  // The current NodeD<E> in the list

        public DoubleLinkedList() {
            top = null;
            cursor = null;
        }

        public E get(int position) {
            cursor = top;
            for (int i = 0; i < position; i++)
                cursor = cursor.getNext();
            return cursor.getData();
        }

        public void add(E item, int position) {
            NodeD<E> placeHolderNode;

            cursor = top;
            for (int i = 0; i < position - 1; i++)
                cursor = cursor.getNext();
            if(cursor == null){
                cursor = new NodeD<E>(item, null, null);
                top = cursor;
            }
            else if (cursor.next == null) {
                cursor.next = new NodeD<E>(item, null, cursor);
            } else {
                cursor.setNext(new NodeD(item, cursor.getNext(), cursor));
            }
        }

        public void delete(int position){
            cursor = top;
            for(int i = 0; i < position; i++){
                cursor = cursor.getNext();
            }
			if(cursor == top){
				top = cursor.next;
			}
            if(cursor.next == null)
            	return;
            if(cursor.prev != null)
            	cursor.prev.next = cursor.next;
            if(cursor.next != null)
            	cursor.next.prev = cursor.prev;


        }

        public String toString() {
            String retVal = "";
            NodeD<E> cur = top;
            while (cur != null) {
                retVal += cur.getData();
                cur = cur.getNext();
            }
            return retVal;
        }


        // Create the rest of the needed methods.


    }

