function postinst()
	local out = "Post installed script called"
    os.execute("mkdir -p /udata/logs/sushi")
    os.execute("mkdir -p /udata/logs/sensei")
    os.execute("mkdir -p /udata/logs/zen-bridge")
    os.execute("chown -R mind:mind /udata")

	return true, out
end
