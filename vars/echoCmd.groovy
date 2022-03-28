def call(args) {
  assert args != null
  sh(script: "echo \'${args}\'")
}