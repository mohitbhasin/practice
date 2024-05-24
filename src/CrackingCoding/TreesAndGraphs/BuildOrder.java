import java.util.*;

class BuildOrder {
	public static void main(String args[]) {
		// char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
		// char[][] dependencies = {{'a','d'},{'f','b'},{'b','d'},{'f','a'},{'d','c'}};
		char[][] dependencies = {{'e','f'},{'e','d'},{'e','a'},{'j','m'},{'j','l'},{'k','j'},{'f','k'},{'f','j'},{'h','j'},{'h','i'},{'i','l'},{'a','d'},{'c','a'},{'c','b'},{'b','d'},{'d','h'},{'d','g'},{'g','i'}};
		char[] projects = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};
		System.out.println("output: "+getOrder(projects, dependencies));
	}


	static Map<Character, List<Character>> graph;
	static List<Character> result;
	static Set<Character> visited;
	public static List<Character> getOrder(char[] projects, char[][] dependencies) {
		graph = new HashMap<>();
		result = new ArrayList<>();
		visited = new HashSet<>();

		for(char project: projects) {
			graph.put(project, new ArrayList<>());
		}

		for(char[] dependency: dependencies) {
			graph.get(dependency[0]).add(dependency[1]);
		}

		for(char project: projects) {
			if(!visited.contains(project)) {
				dfs_order(project, projects);
			}
		}

		return result;
	}

	public static void dfs_order(char project, char[] projects) {
		if(visited.contains(project)) throw new RuntimeException();
		visited.add(project);
		for(char prjt: graph.get(project)) {
			if(!visited.contains(prjt)) {
				dfs_order(prjt, projects);
				visited.add(prjt);
			}
		}
		result.add(0, project);
	}	
}