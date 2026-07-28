# Git Hands-On Lab Solutions

This document provides the exact Git Bash commands needed to complete each step of your hands-on labs.

## Lab 1: Setup and Basics

### Step 1: Setup your machine with Git Configuration

1. **Check if Git client is installed properly:**
   ```bash
   git --version
   ```
2. **Configure user level configuration of user ID and email ID:**
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "your.email@example.com"
   ```
3. **Check if the configuration is properly set:**
   ```bash
   git config --global --list
   ```

### Step 2: Integrate notepad++.exe to Git and make it a default editor

1. **Check if notepad++.exe executes from Git bash:**
   ```bash
   notepad++
   ```
   *(If it doesn't work, follow the instructions provided in the lab to add it to your Windows Environment Variables Path).*
2. **Exit Git bash shell, open bash shell and execute:**
   ```bash
   notepad++
   ```
3. **Create an alias command for notepad++.exe:**
   Open your bash profile (e.g., `~/.bash_profile` or `~/.bashrc`) and add the alias, or run this in the current session:
   ```bash
   alias notepad++="'C:/Program Files/Notepad++/notepad++.exe'"
   ```
4. **Configure the editor:**
   ```bash
   git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
   ```
5. **Verify if notepad++ is the default editor:**
   ```bash
   git config --global -e
   ```
   *(This should open your global `.gitconfig` file in Notepad++).*

### Step 3: Add a file to source code repository

1. **Create a new project "GitDemo":**
   ```bash
   mkdir GitDemo
   cd GitDemo
   ```
2. **Initialize the repository and verify hidden files:**
   ```bash
   git init
   ls -la
   ```
3. **Create a file "welcome.txt" and add content:**
   ```bash
   echo "Welcome to Git" > welcome.txt
   ```
4. **Verify if the file "welcome.txt" is created:**
   ```bash
   ls
   ```
5. **Verify the content:**
   ```bash
   cat welcome.txt
   ```
6. **Check the status:**
   ```bash
   git status
   ```
7. **Make the file tracked by Git repository:**
   ```bash
   git add welcome.txt
   ```
8. **Add multi-line comments using default editor:**
   ```bash
   git commit
   ```
   *(Notepad++ will open. Type your multi-line commit message, save, and close Notepad++ to complete the commit).*
9. **Check if local and "Working Directory" git repository are same:**
   ```bash
   git status
   ```
10. **Signup with GitLab/GitHub and create a remote repository "GitDemo"** *(Manual step in browser)*
11. **Pull the remote repository:**
    *(First, add the remote repository URL provided by GitHub/GitLab)*:
    ```bash
    git remote add origin <your-remote-repository-url>
    git pull origin master
    ```
12. **Push the local to remote repository:**
    ```bash
    git push origin master
    ```

---

## Lab 2: Conflict Resolution

1. **Verify if master is in clean state:**
   ```bash
   git status
   ```
2. **Create a branch "GitWork" and add a file "hello.xml":**
   ```bash
   git checkout -b GitWork
   echo "<hello></hello>" > hello.xml
   ```
3. **Update the content of "hello.xml" and observe the status:**
   ```bash
   echo "<hello>World</hello>" > hello.xml
   git status
   ```
4. **Commit the changes to reflect in the branch:**
   ```bash
   git add hello.xml
   git commit -m "Add hello.xml to GitWork branch"
   ```
5. **Switch to master:**
   ```bash
   git checkout master
   ```
6. **Add a file "hello.xml" to the master with different content:**
   ```bash
   echo "<hello>Master</hello>" > hello.xml
   git add hello.xml
   ```
7. **Commit the changes to the master:**
   ```bash
   git commit -m "Add hello.xml to master branch"
   ```
8. **Observe the log:**
   ```bash
   git log --oneline --graph --decorate --all
   ```
9. **Check the differences with Git diff tool:**
   ```bash
   git diff master GitWork
   ```
10. **Use P4Merge tool to list out differences:**
    *(Assuming P4Merge is configured as your difftool)*:
    ```bash
    git difftool -t p4merge master GitWork
    ```
11. **Merge the branch to the master:**
    ```bash
    git merge GitWork
    ```
    *(This will result in a conflict).*
12. **Observe the git mark up:**
    ```bash
    cat hello.xml
    ```
13. **Use 3-way merge tool to resolve the conflict:**
    ```bash
    git mergetool -t p4merge
    ```
14. **Commit the changes to the master, once done with conflict:**
    ```bash
    git commit -m "Resolve merge conflict for hello.xml"
    ```
15. **Observe the git status and add backup file to the .gitignore file:**
    ```bash
    git status
    echo "*.orig" >> .gitignore
    ```
    *(`.orig` files are created by merge tools as backups).*
16. **Commit the changes to the .gitignore:**
    ```bash
    git add .gitignore
    git commit -m "Ignore merge backup files"
    ```
17. **List out all the available branches:**
    ```bash
    git branch -a
    ```
18. **Delete the branch, which merged to master:**
    ```bash
    git branch -d GitWork
    ```
19. **Observe the log:**
    ```bash
    git log --oneline --graph --decorate
    ```

---

## Lab 3: Git Ignore

1. **Create `.log` files and a `log` folder:**
   ```bash
   mkdir log
   touch log/app.log
   touch error.log
   ```
2. **Update the `.gitignore` file to ignore them:**
   ```bash
   echo "*.log" >> .gitignore
   echo "log/" >> .gitignore
   ```
3. **Verify the git status:**
   ```bash
   git status
   ```
   *(You should not see `error.log` or the `log/` folder listed under untracked files. You will only see `.gitignore` as a modified or untracked file).*

---

## Lab 4: Branching and Merging

### Branching:
1. **Create a new branch "GitNewBranch":**
   ```bash
   git branch GitNewBranch
   ```
2. **List all the local and remote branches available:**
   ```bash
   git branch -a
   ```
3. **Switch to the newly created branch and add some files:**
   ```bash
   git checkout GitNewBranch
   echo "New feature content" > feature.txt
   ```
4. **Commit the changes to the branch:**
   ```bash
   git add feature.txt
   git commit -m "Add feature.txt in new branch"
   ```
5. **Check the status:**
   ```bash
   git status
   ```

### Merging:
1. **Switch to the master:**
   ```bash
   git checkout master
   ```
2. **List out all the differences between trunk (master) and branch:**
   ```bash
   git diff master GitNewBranch
   ```
3. **List out all the visual differences using P4Merge tool:**
   ```bash
   git difftool -t p4merge master GitNewBranch
   ```
4. **Merge the source branch to the trunk:**
   ```bash
   git merge GitNewBranch
   ```
5. **Observe the logging after merging:**
   ```bash
   git log --oneline --graph --decorate
   ```
6. **Delete the branch after merging and observe status:**
   ```bash
   git branch -d GitNewBranch
   git status
   ```

---

## Lab 5: Clean up and Push back to remote Git

1. **Verify if master is in clean state:**
   ```bash
   git status
   ```
2. **List out all the available branches:**
   ```bash
   git branch -a
   ```
3. **Pull the remote git repository to the master:**
   ```bash
   git pull origin master
   ```
4. **Push the changes to the remote repository:**
   ```bash
   git push origin master
   ```
5. **Observe if the changes are reflected in the remote repository:**
   *(Go to your GitHub/GitLab browser window, refresh the page, and verify the recent commits and files are present).*
