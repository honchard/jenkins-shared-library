def call(args) {
  assert args != null
  sh(script: "cat \'${args}\'")
}