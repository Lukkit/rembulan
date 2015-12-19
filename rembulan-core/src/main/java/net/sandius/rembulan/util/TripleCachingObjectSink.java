package net.sandius.rembulan.util;

import java.util.ArrayList;

public class TripleCachingObjectSink extends AbstractObjectSink {

	private Object _0;
	private Object _1;
	private Object _2;

	private final ArrayList<Object> _var;

	private int size;

	public TripleCachingObjectSink() {
		super();
		_var = new ArrayList<>();
	}

	@Override
	public int size() {
		return size;
	}

	protected void setCacheAndClearList(Object a, Object b, Object c) {
		_0 = a;
		_1 = b;
		_2 = c;
		if (size > 3) {
			_var.clear();
		}
		resetTailCall();
	}

	@Override
	public void reset() {
		setCacheAndClearList(null, null, null);
		size = 0;
	}

	@Override
	public void setTo(Object a) {
		setCacheAndClearList(a, null, null);
		size = 1;
	}

	@Override
	public void setTo(Object a, Object b) {
		setCacheAndClearList(a, b, null);
		size = 2;
	}

	@Override
	public void setTo(Object a, Object b, Object c) {
		setCacheAndClearList(a, b, c);
		size = 3;
	}

	@Override
	public void setTo(Object a, Object b, Object c, Object d) {
		setCacheAndClearList(a, b, c);
		_var.add(d);
		size = 4;
	}

	@Override
	public void setTo(Object a, Object b, Object c, Object d, Object e) {
		setCacheAndClearList(a, b, c);
		_var.add(d);
		_var.add(e);
		size = 5;
	}

	@Override
	public void push(Object o) {
		switch (size++) {
			case 0:
				_0 = o;
				break;
			case 1:
				_1 = o;
				break;
			case 2:
				_2 = o;
				break;
			default:
				_var.add(o);
				break;
		}
	}

	private static final Object[] EMPTY_ARRAY = new Object[0];

	@Override
	public Object[] toArray() {
		switch (size) {
			case 0: return EMPTY_ARRAY;
			case 1: return new Object[] { _0 };
			case 2: return new Object[] { _0, _1 };
			case 3: return new Object[] { _0, _1, _2 };
			default:
				Object[] result = new Object[size];
				result[0] = _0;
				result[1] = _1;
				result[2] = _2;
				Object[] tmp = _var.toArray();
				System.arraycopy(tmp, 0, result, 3, tmp.length);
				return result;
		}
	}

	@Override
	public Object get(int idx) {
		switch (idx) {
			case 0: return _0;
			case 1: return _1;
			case 2: return _2;
			default: return idx < size && idx > 2 ? _var.get(idx - 3) : null;
		}
	}

	@Override
	public Object _0() {
		return _0;
	}

	@Override
	public Object _1() {
		return _1;
	}

	@Override
	public Object _2() {
		return _2;
	}

	@Override
	public Object _3() {
		return size > 3 ? _var.get(0) : null;
	}

	@Override
	public Object _4() {
		return size > 4 ? _var.get(1) : null;
	}

}
