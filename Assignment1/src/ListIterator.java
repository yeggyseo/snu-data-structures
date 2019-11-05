public interface ListIterator
{
   //Move Moves the iterator past the next element.
   Object next();

   // Tests if there is an element after the iterator position.
   boolean hasNext();
   void add(Object element);
   void remove();
   void set(Object element);
}