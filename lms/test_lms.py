# noinspection PyUnresolvedReferences
import unittest


class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertNotEqual(True, False)  # add assertion here


if __name__ == '__main__':
    unittest.main()
