# ~/.profile: executed by Bourne-compatible login shells.

if [ -f ~/.bashrc ]; then
  . ~/.bashrc
fi

# path set by /etc/profile
# export PATH
export LD_LIBRARY_PATH=/usr/xenomai/lib:/usr/local/lib:$LD_LIBRARY_PATH
#Might fail after "su - myuser" when /dev/tty* is not writable by "myuser".
mesg n 2>/dev/null

export PATH=$PATH:/sbin:/usr/sbin
if [ "$PS1" ]; then
complete -cf sudo
fi

export TERM=xterm-256color

# export LV2 plugin paths
export LV2_PATH=/home/mind/plugins/mda-lv2/:/udata/plugins/lv2:/usr/lib/lv2
