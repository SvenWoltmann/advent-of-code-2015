package eu.happycoders.adventofcode2015.day2;

import static java.lang.String.format;

class Dimensions {
  private final int length;
  private final int width;
  private final int height;

  Dimensions(int length, int width, int height) {
    this.length = length;
    this.width = width;
    this.height = height;
  }

  int length() {
    return length;
  }

  int width() {
    return width;
  }

  int height() {
    return height;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Dimensions that = (Dimensions) object;
    return length == that.length && width == that.width && height == that.height;
  }

  @Override
  public int hashCode() {
    int result = length;
    result = 31 * result + width;
    result = 31 * result + height;
    return result;
  }

  @Override
  public String toString() {
    return format("%dx%dx%d", length, width, height);
  }
}
