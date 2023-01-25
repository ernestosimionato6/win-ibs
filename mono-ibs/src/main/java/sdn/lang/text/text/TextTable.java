package sdn.lang.text.text;

import java.util.*;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import static sdn.util.SdnObjectMapperReflection.convert;

// import static de.vandermeer.skb.interfaces.transformers.Object_To_StrBuilder.convert;


public class TextTable {

private static int SM = 22;
private static int XL = 35;

public AsciiTable table;
public int size;

public TextTable(int size) {
table = new AsciiTable();
}

public TextTable(String title, int size) {
table = new AsciiTable();
this.size = size;
title(title);
}

public TextTable title(String title) {
table.addRule();
Object[] values = new Object[size];
values[size-1] = title;
table.addRow(values);
table.addRule();
table.addRule();
return this;
}

public TextTable columnHeaders(Object... columns) {
AT_Row row = table.addRow(columns);
for(int i = 0; i < columns.length; i++) 
   row.getCells().get(i).getContext().setTextAlignment(TextAlignment.CENTER);
table.addRule();
return this;
}

public TextTable center(Object... values) {
AT_Row row = table.addRow(values);
for(int i = 0; i < values.length; i++) 
   row.getCells().get(i).getContext().setTextAlignment(TextAlignment.CENTER);
return this;
}


public TextTable row(Object... values) {
AT_Row row = table.addRow(values);
row.getCells().get(0).getContext().setTextAlignment(TextAlignment.RIGHT);
row.getCells().get(0).getContext().setPaddingRightChar(' ');
row.getCells().get(0).getContext().setPaddingRight(1);
row.getCells().get(1).getContext().setPaddingLeftChar(' ');
row.getCells().get(1).getContext().setPaddingLeft(1);
return this;
}

public TextTable rule() {
table.addRule();
return this;
}


public TextTable prop(String key, Object value, Class klass) {
AT_Row row = table.addRow(key, value, klass);
row.getCells().get(0).getContext().setTextAlignment(TextAlignment.RIGHT);
row.getCells().get(0).getContext().setPaddingRightChar(' ');
row.getCells().get(0).getContext().setPaddingRight(1);
row.getCells().get(1).getContext().setPaddingLeftChar(' ');
row.getCells().get(1).getContext().setPaddingLeft(1);
return this;
}

public TextTable prop(String key, Object value) {
AT_Row row = table.addRow(key, value);
row.getCells().get(0).getContext().setTextAlignment(TextAlignment.RIGHT);
row.getCells().get(0).getContext().setPaddingRightChar(' ');
row.getCells().get(0).getContext().setPaddingRight(1);
row.getCells().get(1).getContext().setPaddingLeftChar(' ');
row.getCells().get(1).getContext().setPaddingLeft(1);
return this;
}

public String render() {
table.addRule();
return table.render();
}

public String render(int width) {
table.addRule();
table.getContext().setWidth(width);
return table.render();
}

public TextTable setWidth(int width) { this.table.getContext().setWidth(width); return this;}
public TextTable sm() { table.getContext().setWidth(SM*size); return this; }
public TextTable xl() { table.getContext().setWidth(XL*size); return this; }

public static String renderProps(String title, Map<String, Object> props) {
  TextTable table = new TextTable(title, 3);
  props.forEach((k, v) -> {
	if(v != null) 
		table.prop(k, v, v.getClass());
	else 
		table.row(k, "", "");
  });  
  return table.render();
}

public static String render(String title, Map<String, Object> props) {
  TextTable table = new TextTable(title, 3);
  table.xl();
  props.forEach((k, v) -> {
	if(v != null) 
		table.prop(k, v, v.getClass());
	else 
		table.row(k, "", "");
  });  
  return table.render();
}

public static String render(String title, Object object) throws Exception {
  return render(title, convert(object));
}

public static String render(String title, List items) throws Exception {
  StringBuilder sb = new StringBuilder();
  items.stream().forEach(o -> {
	try { 
	sb.append("\n" + render(title + " " + o.toString(), o) + "\n");
	} catch (Exception e) { throw new RuntimeException(e); }
  });
  return sb.toString();
}




}
