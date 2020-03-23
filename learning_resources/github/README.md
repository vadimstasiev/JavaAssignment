## GitHub Guide
#### Useful Resources:
> - Download [Git](https://git-scm.com/downloads)
> - GitHub [Cheet Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)

# Basics
## Creating a GitHub Rep and Clonning
You can create a new Repository on GitHub through their [website](https://github.com/).
1. When creating a new Repository remember to tick the box to add an initial README file, this makes things easier to setup.
2. On a terminal of your choice, choose a folder, then: `git clone "`**RepositoryName**`"`
## Checking Status
The `git status` command displays the state of the working directory and the staging area. It lets you see which changes have been staged, which haven't, and which files aren't being tracked by **Git**.
1. Go inside the folder of your Repository. (Windows: Shift Right-Click within a folder and choose open terminal or PowerShell)
2. Check the Status to see information such as what **branch** you're currently on: `git status` 
## Commiting
1. Make sure you are on the right **branch** before anything else, **check the status**.
2. The next step is to choose what files will go in the commit.
3. `git add` **FileName**, i.e: `git add index.html` - do this if you want to add a specific file, otherwise:
`git add -A` or `git add .` to add all of the files of the current directory, this will compare all of the files from the current repository against the branch selected and add the files that have been changed.
4. `git commit -m "Write your commit message here"` - The commit message should be very short and should be about the changes you've made to the code.
5. You can commit multiple times but none of the changes will update the online repository until you have pushed them, to do that do: `git push`
# Working in Teams
When working in teams multiple people will want to make changes to multiple different files and as long as these changes don't change the same file you should just be able to do `git pull` whenever you want to check that your version of the **repository** is up-to-date.
However, in a project, it is generally not a good idea for everyone to keep pulling and pushing changes onto a main branch (which is usually **master**), this is why, there are branches.
Branches are essentially copies of a given version(**branch**) of the repository, but once they are created they obviously do not stay up-to-date with any of the other branches but they can be **merged** at which point you can deal with all of the **merge conflicts**, all in one go.
## Creating Branches
To create a branch, do:
1. Make sure you got the latest version of the **branch** that you want to branch, either by clonning or by pulling the new changes (`git pull`).
2. Do `git branch` to view existing branches and to verify what **branch** you're currently on as this will be the branch that will be branched.
3. Do `git branch NameOfTheBranch` to create a branch.
## Switching to a different branch
You can switch to a different branch at any point in time, just be aware that you will need to commit or discart the changes that you've made before doing so.
To switch branches, do:
1. `git checkout NameOfTheBranchYouWantToSwitchTo`
## Merging Changes
If you are the owner of the main branch that you want to merge your branch with you can `pull` the latest changes from that main branch then `git merge MainBranch`.
i.e.
1. `git branch`
	###### Output:
		SecondaryBranch
		*MainBranch
2. `git checkout SecondaryBranch`
3.  ***Make Your Changes to the Repository***
4. `git add -A`
5. `git commit -m "Made some changes to X Module"`
6.  `git checkout MainBranch`
7. `git pull` - this will download any new changes to the MainBranch, possible merge conflicts may be generated here, read about how to solve them [here](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/addressing-merge-conflicts).
8. `git checkout SecondaryBranch`
9. `git merge MainBranch`
10. `git status` - check the status to make sure everything is alright.
11. Now you commit, so:
12. `git add -A`
13. `git commit -m "Merged SecondaryBranch with MainBranch"`
14. `git push`