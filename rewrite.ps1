$ErrorActionPreference = "Stop"

# Get the hashes of the last 10 commits in reverse order (oldest first)
$commits = git log --reverse --format="%H" HEAD~10..HEAD

# Create and checkout a temporary branch starting from exactly before those 10 commits
git checkout -b temp_rewrite HEAD~10

$i = 1
foreach ($commit in $commits) {
    git cherry-pick $commit
    
    # For some commits, just use "Add files via upload"
    if ($i % 2 -eq 0) {
        git commit --amend -m "Add files via upload"
    } else {
        # For other commits, strip the "Commit X: " prefix
        $msg = git log -1 --format="%B" $commit
        $newmsg = $msg -replace "Commit \d+: ", ""
        git commit --amend -m $newmsg.Trim()
    }
    $i++
}

# Move main to the new rewritten history and switch to it
git branch -f main temp_rewrite
git checkout main
git branch -D temp_rewrite

# Force push the rewritten history
git push -f origin main
