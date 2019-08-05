# ~/.profile: executed by Bourne-compatible login shells.

if [ -f ~/.bashrc ]; then
  . ~/.bashrc
fi

# path set by /etc/profile
# export PATH
export LD_LIBRARY_PATH=/usr/xenomai/lib:/usr/local/lib:$LD_LIBRARY_PATH
#Might fail after "su - myuser" when /dev/tty* is not writable by "myuser".
mesg n 2>/dev/null
