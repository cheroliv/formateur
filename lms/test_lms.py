import unittest


class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertNotEqual(True, False)  # add assertion here
    # # Connect to LibreOffice
    # basic = uno.Basic()
    # basic.connect("localhost", "localhost", 8100)
    # if pip.is_package_installed("base"):
    #     print("Le module `base` est installé.")
    # else:
    #     print("Le module `base` n'est pas installé.")


if __name__ == '__main__':
    unittest.main()
