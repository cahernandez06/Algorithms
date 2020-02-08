package Point6;

import java.util.ArrayList;
import java.util.List;

public class TreeN {
	List<Integer> data;
	int level;
	List<TreeN> children;
	
	TreeN(List<Integer> data, int level){
		this.data=data;
		this.level = level;
		children = new ArrayList<TreeN>();
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public int getLevel() {
		return level;
	}

	public List<TreeN> getChildren() {
		return children;
	}
	
	public void addChildren(TreeN node) {
		this.children.add(node);
	}
	
	public void addPerm(List<Integer> newNums, int level) {
		
		if (this.getLevel()==level)
			//Run thought the children adding the new number
			for (int numCurr:newNums) {
				List<Integer> tmpData = this.getData();
				tmpData.add(numCurr);
				TreeN newChild = new TreeN(tmpData,level+1);
				this.addChildren(newChild);
				}
		else 
			for (TreeN child:this.getChildren())
				child.addPerm(newNums, level+1);
	}

}