package leetcode;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

  private Iterator<Integer> iterator;
  private boolean cached;
  private int cachedV;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    cached = false;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (!cached) {
      cachedV = iterator.next();
      cached = true;
    }
    return cachedV;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (cached) {
      cached = false;
      return cachedV;
    } else {
      return iterator.next();
    }
  }

  @Override
  public boolean hasNext() {
    if (cached) {
      return true;
    }
    return iterator.hasNext();
  }
}
