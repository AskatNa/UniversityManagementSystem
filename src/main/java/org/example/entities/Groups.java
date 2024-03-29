package org.example.entities;
public class Groups {
    public static final Groups SE_2301 = new Groups(Group.SE_2301);
    public static final Groups SE_2302 = new Groups(Group.SE_2302);
    public static final Groups SE_2303 = new Groups(Group.SE_2303);

    public enum Group {
        SE_2301, SE_2302, SE_2303
    }
    private Group group;
    public Groups(Group group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "Group: " + group;
    }
    public static Groups[] getAllGroups() {
        return new Groups[]{
                new Groups(Group.SE_2301),
                new Groups(Group.SE_2302),
                new Groups(Group.SE_2303)
        };
    }
}
